check aditya verma's vids OHHH
​
* subsets of size == 1 will be at 0th level
* subsets of size == 2 will be at 1st level and so on;
​
[1,2,2]
​
level 0 --------------------||-------- level 1---------------- ||------- level 2-------
-                                       ||                                                ||
start = 0,i = 0 A[i] = 1      ||          start=1,i=1,A[i]=2         ||           start=2,i=2,A[i]=2
subset = [1]                      ||         subset = [1,2]                ||           subset = [1,2,2]
*goto next level*               ||         *goto next level*
*then pop happens*          ||         *then pop happens*       ||          *then pop happens*
||                                               ||
||  i(1) gets increment to i+1(2) ||*only one subset was possible*
|| thus new subset =[1,2]          ||of size = 3* so return
||  *goto next level*                   ||
||*then pop happens again*    ||
||                                                ||
start = 0, i = 1A[i] = 2       ||         start = 1, i = 1, A[i] = 2  ||   *only one subset was possible*
subset = [2]                       ||         subset = [2,2]                 ||          of size = 3* so return
*goto next level**               ||          *goto next level*            ||
*then pop happens*           ||         *then pop happens*       ||
||                                                 ||
start = 0, i = 2,A[i] = 2      ||  *only 3     subset are possible* ||   *only one subset was possible*
subset = [2]                       ||   *of size = 2*                           ||    *of size = 3*
​
**Thus to remove duplicates just compare if at particular level if current element is
equal to previous element or not**
​
​
​
​
​