class Solution:
    def maximumMeetings(self, n, start, end):
        """
        Calculates the maximum number of meetings that can be scheduled without overlapping.
        
        Args:
            n (int): The number of meetings.
            start (List[int]): The list of start times for each meeting.
            end (List[int]): The list of end times for each meeting.
        
        Returns:
            int: The maximum number of meetings that can be scheduled.
        """
        # Create a list of meetings containing start and end times
        meetings = []
        for i in range(len(start)):
            meetings.append([start[i], end[i]])
        
        # Sort meetings by end time
        meetings = sorted(meetings, key=lambda x: x[1])
        
        result = 1
        prev_end_time = meetings[0][1]
        
        # Iterate through meetings and check for overlap
        for i in range(1, len(start)):
            start_time = meetings[i][0]
            end_time = meetings[i][1]
            
            # If the previous meeting's end time is less than the current meeting's start time,
            # increment the result count and update the previous end time
            if prev_end_time < start_time:
                result += 1
                prev_end_time = meetings[i][1]
        
        return result



#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys

#Contributed by : Nagendra Jha

if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases) :
        n = int(input())
        start = list(map(int,input().strip().split()))
        end = list(map(int,input().strip().split()))
        ob=Solution()
        print(ob.maximumMeetings(n,start,end))
# } Driver Code Ends