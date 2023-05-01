#User function Template for python3

def reverseWord(s):
    # String are immutable in python
    
    stringList = list(s);
    
    i = 0;j = len(s)-1;
    
    while i<j:
        stringList[i],stringList[j] = stringList[j],stringList[i];
        i += 1;
        j -= 1;
    
    return "".join(stringList);


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == "__main__":
    t = int(input())
    while(t>0):
        s = input()
        print(reverseWord(s))
        t = t-1

# } Driver Code Ends