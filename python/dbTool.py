__author__ = 'persen'

from mapper import user
from sqlalchemy import *
from sqlalchemy.orm import *
import json

def get_Session():
    engine = create_engine("oracle://billing:billing@172.168.1.246:1521/bssgx", echo=False)
    user.Base.metadata.create_all(engine)
    Session =sessionmaker(bind=engine)
    return Session

class dbTool():
    session = None

    def __init__(self):
        self.session = get_Session()()

    def getUser(self):
        result = self.session.query(user.Users)#.filter(user.Users.user_id == 1)
        return result

