
//Problem is picked from HacherRank
//Here We have given string including brackets
//And we have to check if it is balanced or not

static String isBalanced(String s) {
    Stack<Character> st = new Stack<>();
    st.push('@');
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[')
            st.push(s.charAt(i));
        else {
            if (s.charAt(i) == '}' && st.peek() == '{' && !st.isEmpty())
                st.pop();
            else if (s.charAt(i) == ')' && st.peek() == '(' && !st.isEmpty())
                st.pop();
            else if (s.charAt(i) == ']' && st.peek() == '[' && !st.isEmpty())
                st.pop();
            else {
                count++;
                break;
            }
        }
    }
    if (st.peek() == '@' && count == 0)
        return "YES";
    else
        return "NO";
}