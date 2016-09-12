from sqlalchemy import *
engine = create_engine("oracle://billing:billing@172.168.1.246:1521/bssgx", echo=False)
metadata = MetaData(engine)
users = Table('users', metadata,
    Column('user_id', Integer, primary_key=True),
    Column('name', String(40)),
    Column('age', Integer),
    Column('password', String(40)),
)

i = users.insert()
i.execute(user_id=1, name='Mary', age=30, password='secret')
i.execute({'user_id': 2, 'name': 'John', 'age': 42},
          {'user_id': 3, 'name': 'Susan', 'age': 57},
          {'user_id': 4, 'name': 'Carl', 'age': 33})
s = users.select()
rs = s.execute()
row = rs.fetchone()
print 'Id:', row[0]
print 'Name:', row['name']
print 'Age:', row.age
print 'Password:', row[users.c.password]
for row in rs:
    print row.name, 'is', row.age, 'years old'