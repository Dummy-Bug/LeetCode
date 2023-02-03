class Solution 
{
    public List<Integer> findAnagrams(String s, String p) 
    {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Integer,Integer> Hash_map = new HashMap<>();
        
        int unique_count = 0;
        
        for (int i = 0; i<p.length();i++)
        {
            int curr_char = p.charAt(i);
            
            if(!Hash_map.containsKey(curr_char) )
            {
                Hash_map.put(curr_char,0);
                unique_count += 1; 
            }
            Hash_map.put(curr_char,Hash_map.get(curr_char) + 1);
        }
        
        int i = 0; int j = 0;
        
        while (j<s.length())
        {
            int curr_char = s.charAt(j);
            
            if ( Hash_map.containsKey(curr_char) )
            {
                Hash_map.put( curr_char,Hash_map.get(curr_char)-1 );
                if ( Hash_map.get(curr_char) == 0 )
                {
                    unique_count -= 1;
                }
            }
            
            if (j-i+1 < p.length())
            {
                j += 1;
            }
            else
            {
                if (unique_count == 0)
                {
                    result.add(i);
                }
                int last_char = s.charAt(i);
                if (Hash_map.containsKey(last_char))
                {
                    if ( Hash_map.get(last_char) == 0 )
                    {
                        unique_count += 1;
                    }
                    Hash_map.put(last_char,Hash_map.get(last_char)+1);
                }
            i += 1; j += 1;
            }
            
        }
    return result ;
    }
}