class Solution {
    public boolean hasMatch(String s, String p) {

        int i;
        for(i = 0; i < p.length(); i++){
            if (p.charAt(i) == '*'){
                break;
            }
        }
        int starIndex = i;
        String p1 = p.substring(0,starIndex);
        String p2 = p.substring(starIndex+1);

        int index = s.indexOf(p1);
        if (index == -1) return false;

        int nextIndex = index + starIndex;

        int secondIndex = s.indexOf(p2,nextIndex);
        if (secondIndex == -1) return false;

        return true;

    }
}