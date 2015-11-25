import json
def convert_to_builtin_type(obj): print 'default(', repr(obj), ')'

def serialize_instance(obj):
    print vars(obj)
    d = { '__classname__' : type(obj).__name__ }
    d.update(vars(obj))
    return d
# Dictionary mapping names to known classes

class student:
        name=""
        age=0
        __weight=0
        def __init__(self,n,a,w):
                self.name=n
                self.age=a
                self.__weight=w
        def speak(self):
                print("%s say I am %d years old weight is %d kg" \
                %(self.name,self.age,self.__weight))
        def convert_to_builtin_type(self): 
            print 'default(', repr(self), ')' 

stu=student('luren',20,70)
stu.speak()
print json.dumps(stu, default=serialize_instance)
print (json.dumps(stu, default=lambda obj: obj.__dict__))
print '------------------'
print dir(stu)
for k in dir(stu):
    print type(k);
    print getattr(stu,k);
    

print '------------------'
#print stu.name
#print json.dumps(stu, default=serialize_instance)
class me(student):
    def test(self):
        print self.name;
        print self.speak();
       
met =me('cyj',10,30);
met.test();
print met.age;

classes = {
    'Point' : student
}

def unserialize_object(d):
    clsname = d.pop('__classname__', None)
    if clsname:
        cls = classes[clsname]
        obj = cls.__new__(cls) # Make instance without calling __init__
        for key, value in d.items():
            setattr(obj, key, value)
            return obj
    else:
        return d
    
from datetime import date, datetime
 
class MyClass(object):
    def __init__(self):
        self.a=1
        self.b=2
 
def _default(obj):
    if isinstance(obj, datetime):
        return obj.strftime('%Y-%m-%d %H:%M:%S')
    elif isinstance(obj, date):
        return obj.strftime('%Y-%m-%d')
    elif isinstance(obj, MyClass):    
        return {'a':obj.a,'b':obj.b}
    else:
        #return ''
        #return str(obj)
        raise TypeError('%r is not JSON serializable' % obj)
 
mc = MyClass()
print json.dumps({'now': datetime.now(), 'today': date.today(), 'mc': mc},default=_default)
#==>   {"mc": {"a": 1, "b": 2}, "now": "2012-08-16 19:50:58", "today": "2012-08-16"}

#error because __XXXX is private ,it only can be used in class 
#print stu.__weight 