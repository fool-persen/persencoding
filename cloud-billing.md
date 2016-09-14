##cloud-billing
###一、信息增强（IE）
####1. 类：EnhanceLocalServiceImpl  
* 方法：
 - boolean isCallable(Session session)  
描述：从session中获取sessionMap（存放），再在map中查找是否存在key为serviId=IE的数据，存在则返回true，否则返回false。
 - Object marshal(Session session)  
 描述：返回session中的request。
 - void unmarshal(Session session, Object answer)  
描述：把answer和serviceId组装放入session中的sessionMap成员中。

####2. 类：EnhanceRemoteServiceImpl  
* 成员：
 - private Class<?> requestClass; // 请求类
 - private Class<?> enhanceClass; // 增强类
 - private List\<EnhanceServiceWrapper> services; // 服务调用列表
 - private List\<Map\<Method, MethodGroup>> copyFromMaps; // 存放请求类成员与服务request映射关系 \<getter(requestClass/enhanceClass), setter(service.request)>
 - private List\<Map\<Method, MethodGroup>> copyToMaps; // 存放增强类成员于服务answer映射关系  \<setter(enhanceClass), getter(service.answer)>
* 配置：  
	
		<bean id="enhanceRemoteService" class="com.tydic.cloud.billing.ie.EnhanceRemoteServiceImpl">
        <property name="requestClass" value="com.tydic.cloud.billing.ie.EnhanceRequest"/>
        <property name="enhanceClass" value="com.tydic.cloud.billing.ie.EnhanceAnswer"/>
        <property name="services">
            <list>
                <ref bean="IEServiceImpl_1"/>
                <ref bean="IEServiceImpl_2"/>
            </list>
        </property>
    </bean>
描述：   
 1. 配置指定请求类型和增强类型； 
 2. services,配置为list成员为EnhanceServiceWrapper类型（配置参见3）
* 方法：  
 - void init()  
 描述：@PostConstruct注解函数，用于bean初始化；解析services中的服务类中的copyFromMap和copyToMap，写入到copyFromMaps和copyToMaps中。
 - Object call(Object request)  
描述： 顺序调用服务列表；调用extract对request和answer进行解析，封装为service需要的入参类型；调用service的call函数，进行服务调用；对服务返回值调用merge函数，将返回结果封装入answer。  
 - Object extract(int index, Object request, Object answer, Class<?> classOfT)  
 描述：参数描述如下表。通过index获取copyFromMaps中的映射关系，取request或answer中的字段，set写入service请求类型对象，返回该对象。  
 
     入参|类型|描述
     ---|---|----
     index|int|对应services中的pos
     request|requestClass|请求类型
     answer| enhanceClass|增强类型
     classOfT|Class<?>|service的请求泛型用于生成出参对象

 - void merge(int index, Object answer, Object output)   
描述：参数描述如下表。通过index获取copyToMaps中的映射关系，去output中的字段，set写入answer，answer存放的结果就可以用于下一个服务调用的入参。  

      入参|类型|描述
      ---|---|---
      index|int|对应services中的pos
      answer|enhanceClass|增强类型
      output|Class<?>|service的应答类型对象
      
####3. 类：EnhanceServiceWrapper
* 成员: 
 - private IEnhanceBusiService\<Object, Object> service; // IE服务列表
 - private Map\<String, String> copyFromMap; 
 - private Map\<String, String> copyToMap;
* 配置：

		<bean id ="IEServiceImpl_1" class="com.tydic.cloud.billing.ie.EnhanceServiceWrapper">
			<property name="service">
				<bean class="com.tydic.cloud.billing.ie.SampleServiceImpl"/>
			</property>
			<property name="copyFromMap">
				<map>
					<entry key="field1" value="input.field1"/>
					<entry key="field1" value="output.field2"/>
					<entry key="field1" value="field3"/>
				</map>
			</property>
			<property name="copyToMap">
				<map>
					<entry key="field2" value="field1"/>
				</map>
			</property>
		</bean>
		
	描述：
	1. service为对应的IE服务。
	2. copyFromMap配置com.tydic.cloud.billing.ie.EnhanceRequest和com.tydic.cloud.billing.ie.EnhanceAnswer中获取字段封装为service的request泛型对象。input前缀在EnhanceRequest中获取，output前缀在EnhanceAnswer中获取，默认时先在EnhanceRequest中查找，然后在EnhanceAnswer中查找。
	3. copyToMap配置com.tydic.cloud.billing.ie.EnhanceAnswer成员对service的answer泛型对象成员的映射关系。

###二、流程控制（PC）
####1. 类：SessionServiceImpl
* 方法
 - Session getSession(String sessionId, int ratingGroup, String serviceNumber)  
描述：通过入参条件查询库表USER_SESSION，获取UserSessionData对象，调用toSession函数，返回session，不存在返回null。
 - List\<Session> getSessions(String sessionId, List\<Integer> ratingGroups, String serviceNumber)  
描述：功能同上，查询多个ratingGroup，返回List\<Session>。
 - List\<Session> getSessions(String sessionId, String serviceNumber)  
 描述：功能同上，查询条件为sessionId和serviceNumber。
 - void insert(Session session, boolean ratingGroupEnabled)  
 描述：ratingGroupEnabled标示是否采用子话单；调用getSessionMap，获得sessionMap，生成UserSessionData对象，执行数据库insert操作。
 - void update(Session session, boolean ratingGroupEnabled)  
 描述：同上，执行数据库update操作。
 - void delete(Session session)  
 描述：根据session.sessionId和session.serviceNumber，执行数据库删除操作。
 - Map\<String, Object> getSessionMap(Session session, boolean ratingGroupEnabled)  
 描述：不采用自话单方式，直接返回session中的sessionMap；否则，判断该session是否为主会话，如果是，提取sessionMap中所有需要保留主会话（masterServiceIds中定义）的键值对用于返回，不是则保留除了masterServiceIds定义的serviceId的其他会话信息。

####2. 类：UserSessionData
描述：库表USER_SESSION对应pojo。  

* 方法：
 - UserSessionData(Session session, Map<String, Object> sessionMap）  
 描述：把session对象转化为数据库对象。session功能见类session，sessionMap存放\<ServiceId, 服务调用结果>，eg:\<IE, obj>。根据session中的信息组装UserSessionData，并对sessionMap内容进行序列化后赋值给session中的body。  
 序列化过程：使用Hessia进行序列化，然后用gzip进行加密。
 - Session toSession()  
 描述：数据操作对象转化为会话对象。反序列化body字段，提取request和SessionMap。
 - void reset()
 描述：重置会话，更新beginTime为updateTime，清空SessionMap。
 
####3. 类：ProcessControlServiceImpl
* 成员：
 - private ApplicationContext applicationContext; // spring容器对象，用于获取bean
 - private IMQProducerService mqProducerService; // 指定mq生产者服务，用于消息应答
 - private IProcessBusiService busiService; // 指定不同业务服务（预付费/后付费）
 - private List\<ComServiceWrapper> services; // busiService指定的业务，需要调用的服务列表，需要制定调用顺序（IE->Rating->Charging）
 - private ISessionService sessionService; // 指定会话服务(session操作)
 - private List\<ExceptionConfig> exceptionConfigs; // 异常处理列表，services调用发生异常时，针对不同的异常进行不同的ExceptionHandler处理。
 - private int retries = 3; // 重试次数
 - private boolean statEnabled = true; // 是否统计
 - private boolean ratingGroupEnabled = true; // 是否以子话单方式
 - private boolean writeOnDaySwitch = false; // 日切换点是否出单
 - private boolean writeOnMonthSwitch = false; // 月切换点是否出单
 - private long writePerTime = 0; // 多长时间后出单

* 配置：
		
		<!-- 定义IE服务封装类 -->
		<bean id="comServiceWrapperIE"  class="com.tydic.cloud.billing.pc.ComServiceWrapper">
			<property name="localService" ref="localServiceIE" />
			<property name="remoteService" ref="remoteServiceIE" />
		</bean>
		<!-- 定义RATING服务封装类 -->
		<bean id="comServiceWrapperRATING"  class="com.tydic.cloud.billing.pc.ComServiceWrapper">
			<property name="localService" ref="localServiceRATING" />
			<property name="remoteService" ref="remoteServiceRATING" />
		</bean>
		<!-- 定义业务服务 -->
		<bean id="processBusiService" class="com.tydic.cloud.billing.pc.ProcessOcsBusiServiceImpl" />
		<!-- 定义session处理类 -->
		<bean id="sessionService" class="com.tydic.cloud.billing.ds.SessionServiceImpl" />
		
		<bean id="processControlService" class="com.tydic.cloud.billing.pc.ProcessControlServiceImpl">
			<property name="retries" value="3" />
			<property name="statEnabled" value="true" />
			<property name="sessionService" ref="sessionService" />
			<property name="busiService" ref="processBusiService" />
			<property name="services">
				<list>
					<ref bean="comServiceWrapperIE"/>
					<ref bean="comServiceWrapperRATING"/>
				</list>
			</property>

			<property name="exceptionConfigs">
				<list>
					<bean class="com.tydic.cloud.billing.pc.ExceptionConfig">
						<property name="classOfException" value="com.tydic.cloud.billing.api.exception.BusiException" />
						<property name="handler" ref="exceptionHandlerTest" />
					</bean>
				</list>
			</property>
		</bean>
		
	PS：remoteServiceIE参见信息增强类配置。
	
* 方法： 
 - public void init()  
 描述：初始化局部变量，对exceptionConfigs列表进行排序（子类排在父类前面）。
 - public void onMessage(RequestBase request, String topic, long bornTimestamp)  
 描述：类核心业务函数，mq消息获取类型为RequestBase。
     * 1. request.msgType取值返回{1:I包, 2:U包, 3:T包, 4:非OCS包}，根据取值判断消息类型是否为OCS。
     * 2. 非OCS，调用doOther业务处理函数
     * 3. 是OCS，判断是否以子话单方式（ratingGroupEnabled），是调用doSlave，否调用doMaster。
     * 4. 判断是否需要统计信息（statEnabled），是更新全局运行耗时，debug模式则打印运行报告。
     * 5. 发生异常组建session，设置ResultCode失败码，调用doAnswer应答。
 - private void doAnswer(String responseTopic, Session session, List\<SessionExecutor> sessionExecutors)  
 描述：sessionExecutors中提取子会话列表，根据主会话session和子会话列表，调用业务服务（busiService），获取应答消息。调用mq生产者服务（mqProducerService）向responseTopic发送应答消息。
 - private void doRequest(Session session, Session masterSession)
     * 1. 把子会话session，合并到主会话masterSession的sessionMap中。
     * 2. 循环调用服务列表（services）  
         - 获取本地服LocalService，调用LocalService.isCallable判断该服务是否已调用，调用则continue。
         - 获取远程服务RemoteService和服务ID。
         - 调用LocalService.marshal提取远程服务请求消息。
         - 调用RemoteService.call执行远程服务。
         - 调用LocalService.unmarshal把远程服务结果合并到会话中。
         - 如果需要报告，则调用doStat记录调用耗时信息。
     * 3. 判断MsgType（T包和Other包）写调用writeOut写话单。
     * 4. 冲突异常，调用doStat，session反序列化返回。
     * 5. Exception，顺序判断异常列表，一致则调用配置的异常处理方法。
 - private void doSlave(RequestOcsBase requestOcs, Timestamp timestamp)  
 描述：子话单处理方式。
     * 1. 从请求消息中获取子请求列表、sessionId、serviceNumber和是否为terminal消息。
     * 2. terminal消息，则通过session服务获取全部会话信息。
     * 3. 非terminal消息，从子请求中提取ratingGroup，并增加主会话ratingGroup（-1），根据ratingGroup列表通过session服务获取session列表。
     * 4. 提取主会话（session）和子会话map（sessionMap<ratingGroup, session>）。
     * 5. 主会话为空时，消息类型不是I包则抛出异常，否则创建主会话、执行行为INSERT。
     * 6. 主会话不为空，session中设置消息中seqNo、msgType，更新时间，执行行为UPDATE。
     * 7. 定义子会话操作列表（SessionExecutor，结构中存放session和数据库执行行为insert/update）。
     * 8. 循环处理每个子请求。
        - 子请求设置当前处理请求。
        - 把子请求类型转换为OCS子请求类型（SubRequestOcsBase）。
        - sessionMap获取当前请求对应的子会话。
        - 子会话不存在，创建session，数据库操作行为INSERT；子会话存在，更新会话信息，数据库操作行为UPDATE。放入子会话操作列表。
        - 调用doRequest处理该子会话。
        - 子请求设置当前请求为空。
     * 9. 更新会话，如果为T包，删除会话；否则调用reachWritePoint判断是否满足话单切换，满足则写详单并清空会话；更新会话。
     * 10. 调用doAnswer发送应答。
 - private void doMaster(RequestOcsBase requestOcs, Timestamp timestamp)  
 描述：不区分主子话单处理方式。
     * 1. 从请求中提取sessionId、serviceNumber。
     * 2. 以ratingGroup通过会话服务数据库中提取会话session。
     * 3. 会话为空时，消息类型不是I包则抛出异常，否则创建主会话、执行行为INSERT。
     * 4. 主会话不为空，session中设置消息中seqNo、msgType，更新时间，执行行为UPDATE。
     * 5. 调用doRequest处理该会话。
     * 6. 更新会话，如果为T包，删除会话；否则调用reachWritePoint判断是否满足话单切换，满足则写详单并清空会话；更新会话。
     * 7. 调用doAnswer发送应答。
 - private void doOther(RequestBase request, Timestamp timestamp)  
 描述：非OCS话单处理方式。
     * 1. 提取子请求；创建session。
     * 2. 子请求为空，调用doRequest处理该sessio。
     * 3. 子请求不为空，则循环处理子请求，设置当前处理子请求后，调用doRequest处理session。
     * 4. 调用doAnswer发送应答。

###三、转换代理（TA)
####1. 类：TransferAgentServiceImpl
* 成员：  
 - private ISource source; // spring注入实现类
 - protected ITarget target; // spring注入实现类
* 方法：
 - public void execute()
 描述：判断source类型为ISyncSource的实现，则while(true)，source.readObject,target(writeObject);目前同步的实现支持文件（FileSourceImpl）和表（TableSourceImpl）两种方式。否则无线休眠，此时source实现为MQ（MQSourceImpl）实现。  
 
####2. 类：FileSourceImpl
* 方法：
 - public void init()
描述：验证路径、通配符、时间有效性，初始化局部变量，对配置的目标类和解析配置进行解析， （ConfigBuilderUtils.parse(classOfT, mappedLocation)）获得记录配置（recordConfig）。解析过程（TODO，此处需要后续详细添加），xml转化为bean，如果xml存在则通过xml方式，不存在则使用类注解。
 - public Object readObject()  
 描述：从src目录下读取文件记录，按照配置规则进行解析，解析出对象返回。  
     * 1. while(true)循环，查看行迭代器是否为空或者存在下一条记录；存在，读取该行，调用parse函数进行解析，更新文件处理日志记录并判断是否需要记录日志，需要则调用saveLog函数，返回解析结果。
     * 2. 行迭代器为空或文件没有下一条记录，查看读取的文件列表是否为空，如果为空，循环扫描src目录，按照配置的正则表达式筛选文件，直到有文件跳出循环；不为空，则记录当前文件处理完成，调用saveLog记录文件处理日志。
     * 3. 判断文件列表是否已经处理完，处理完则晴空文件列表，跳回1的循环。
     * 4. 在文件列表中取一个文件，打开文件，调用getLog获取文件日志，判断文件日志是否存在断点，存在则行迭代器循环至断点处。跳回1处。
 - private Object parse(String record)  
 描述：把文件行信息解析成为配置类（classOfT）对象。
 - public void getLog()  
描述：根据文件名获取日志中的记录，存在直接返回，不存在则吸入一条并返回。
 － public void saveLog(boolean abnormal)  
 描述：写文件处理日志，并根据文件结束与否选择不同的操作方式对文件进行删除、移动或改名；并调用文件监听对象进行处理。  
 
####3. 类：TableSourceImpl
* 方法：
 - public void init()  
 描述：@PostConstruct注解函数，通过反射方式，配置数据类型和dao操作类获取查询方法和更新方法。
 - public Object readObject()  
 描述：数据库中批量查询数据，提供fetchsize方式，每次返回一条记录。
 - public void save(int from, int to)  
 描述：调用反射获取更新操作方法对处录进行更新操作。
 
####4. 类：MQSourceImpl
 * 方法：
  - public void init()  
  描述：bean初始化函数，成员初始化和验证。  
      * 1. 验证注入的listener是否为IFileListener接口，否则报错。
      * 2. 文件切换策略（policy）。ROWS：刷新记录数等于文件记录数；TIME：启动timer，定时调用listener成员的onFinish方法。
  - public void onMessage(Object request, String topic, long bornTimestamp)  
  描述：文件切换策略为空，直接调用listener.writeObject(listener为Table时可用)。把消息写入listener，存在文件切换策略；ROWS：到达文件限制时调用listener.onFinish；到达flush数时调用listener.onSave;TIME:到达flush数时调用listener.onSave。
 
####5. 类：MQTargetImpl
* 方法：  
 - public void writeObject(Object object)  
 描述：直接调用配置中的mq生产者发送object到指定的topic中。  
 
####6. 类：FileTargetImpl
* 成员：
 - private Class<?> classOfT; // 输入类
 - private org.springframework.core.io.Resource mappedLocation; // 配置文件位置
 - private IEvaluationContextFactory evaluationContextFactory; // 表达式工厂类
 - private DistributeConfig distributeConfig; // 配置结果
 - private Map<String, FileData> fileDataMap;
* 方法：
 - public void init()  
 描述：通过配置文件mappedLocation和输入类classOfT，解析出配置结果存放distributeConfig。解析过程，xml转化为bean。（TODO，此处需要后续详细添加）   
 - public void writeObject(Object object)  
 描述：把object对象，按照配置写入相应的文件输出。  
     * 1. 循环分发配置结果，如果ruleCondition为空或者取值为false则取下一条。
     * 2. 通过ruleFileName获取文件名。
     * 3. 组装文件全名，在fileDataMap中查找，如果不存在，则生成一个文件并方式fileDataMap，写入文件头；同时检查fileDataMap.size是否超过配置中的最大分发文件数，超过则报异常。
     * 4. 调用writeBody写结果；调用doStat记录统计。
 - public void onSave(String filename)  
 描述：从打开的文件map中查找当前文件然后flush到磁盘。
 - public void onFinish(String filename)  
 描述：循环所有打开的文件map，通过FileData配置判断文件是否需要写入文件头和文件尾，如果需要则调用writeHeadTail和writeHeadTail写入记录，关闭文件并改名；清空文件map。
 - private void writeBody(BufferedRandomAccessFile out, RecordConfig recordConfig, Object object)  
 描述：把object按照配置取相应字段加入分隔符写入文件。
 
####7. 类：TableTargetImpl
* 方法：
 - public void init()
 描述：初始化变量，把配置整合到helpers中，通过TargetHelper把配置的dao类和pojo类整合为TargetHelper对象。
 - public void writeObject(Object object)  
 描述：把object写入类成员objects中。
 - public void onSave(String filename)   
 描述：调用doUpdate进行数据库操作。
 - public void onFinish(String filename)  
 描述：调用doUpdate进行数据库操作。
 - private void doUpdate()  
 描述：循环objects逐个处理每个成员；对每个object循环配置的helps，匹配对应的配置表达式，满足调用则调用配置中的方法，进行数据库操作。
 
			