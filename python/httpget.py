__author__ = 'persen'

#!/usr/bin/env python
#coding=utf8

import httplib

httpClient = None

try:
    httpClient = httplib.HTTPConnection('www.baidu.com', 80, timeout=30)
    httpClient.request('GET', '/Users/persen/githup/persencoding/php/test.php')

    response = httpClient.getresponse()
    print response.status
    print response.reason
    print response.read()
except Exception, e:
    print e
finally:
    if httpClient:
        httpClient.close()