__author__ = 'persen'

from sqlalchemy import *
engine = create_engine("oracle://billing:billing@172.168.1.246:1521/bssgx",
                       echo=False)
conn = engine.connect()

result = conn.execute('select * from users')

for row in result:
    print row
conn.close()