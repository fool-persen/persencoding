from sqlalchemy import *
from sqlalchemy.orm import *

metadata = MetaData()
engine = create_engine("oracle://billing:billing@172.168.1.246:1521/bssgx", echo=False)
metadata.bind = engine

users = Table('users', metadata,
    Column('user_id', Integer, primary_key=True),
    Column('name', String(40)),
    Column('age', Integer),
    Column('password', String(40)),
)

class Users(object):
    def __init__(self, user_id, name, age, password):
        self.user_id = user_id
        self.name = name
        self.age = age
        self.password = password

    def __repr__(self):
        return "<users('%d', '%s', '%d', '%s')>" % (self.user_id, self.name, self.age, self.password)

mapper(Users, users)
Session = sessionmaker(bind=engine)
session = Session()
user1 = Users(10, 'user10', 10, 'pass10')
user2 = Users(11, 'user11', 111, 'pass11')

#session.add(user1)
#session.add(user2)
#session.commit()
#session.query(Users).filter(Users.user_id == 10).delete()

session.query(Users).filter(Users.user_id == 1).update({"age": Users.age - 10, "name": "haha"})
result = session.query(Users).filter(Users.user_id == 1)
for row in result:
    print(row)
session.commit()