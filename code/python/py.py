#encoding:utf-8
import json
d = {'a':1, 'b':0, 'c':1, 'd':0};
d['e']='3';
print d.has_key('name')
print 'name' in d.keys()
#d['e']=3;
if (d['a'] ==None or d['a']==2):
    print '-------------'
for k in d:
     print k+"=="+str(d[k])+"\t"+d['e'];
print "succ";

dict = {'Name': 'Zara', 'Age': 7, 'Class': 'First'};

del dict['Name']; #  
dict.clear();     #  
del dict ;        #  

json_input = '{ "one": 1, "two": { "list": [ {"item":"A"},{"item":"B"} ] } }'
 
try:
    decoded = json.loads(json_input)
 
    # pretty printing of json-formatted string
    print json.dumps(decoded, sort_keys=True, indent=4)
 
    print "JSON parsing example: ", decoded['one']
    print "Complex JSON parsing example: ", decoded['two']['list'][1]['item']
   
except (ValueError, KeyError, TypeError):
    print "JSON format error"
