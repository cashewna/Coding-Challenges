package _1108_DefangingAnIPAddress;
// Runtime 0ms O(1)

public class Solution2 {
    public String defangIPaddr(String address) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                answer.append("[.]");
            } else {
                answer.append(i);
            }
        }
        return answer.toString();
    }
}
