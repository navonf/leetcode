class RotateString {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;
        if(A.isEmpty()) return true;
        // Linear, O(n).
        for(int i = 0; i < A.length(); i++) {

            // Check if strings are the same.
            // Are they equal? return here
            if(A.equals(B)) return true;

            // They were not, strip the first character
            A = A.substring(1, A.length()) + A.charAt(0);
        }

        return false;

    }
}
