class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<String>();
        
        for(String email : emails) {
            StringBuilder sb = new StringBuilder();
            int current = 0;
            
            while(email.charAt(current) != '+' && email.charAt(current) != '@') {
                if(email.charAt(current) != '.') {
                    sb.append(email.charAt(current));
                }
                current++;
            }
            
            while(email.charAt(current) != '@') {
                current++;
            }
            
            while(current < email.length()) {
                sb.append(email.charAt(current));
                current++;
            }
            
            set.add(sb.toString());
        }
        return set.size();
    }
}
