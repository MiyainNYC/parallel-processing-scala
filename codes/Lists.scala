   val list = List(10,30,26,35,7,9,55,23)         
   
   def square(x:Int) = x*x                        
   
   list.map( square )                            
   list.map( elem => square(elem) )               
   list.map( square(_) )                          
   list.map( elem => elem * elem )                

   list.filter( elem => elem>35 )                 
   list.filter( elem => elem%2 == 0)              
   def greaterThan35(x:Int) = { if(x > 35) true else false }  
   list.filter(greaterThan35)                     
   
   list.reduce(  (x,y) => x+y )                 
