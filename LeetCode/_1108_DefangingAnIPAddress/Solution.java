package _1108_DefangingAnIPAddress;
// Defanging = replace each . with [.]
// Runtime 3ms, seems like regex patterns are slow

class Solution {
  public String defangIPaddr(String address) {
    String pattern = "([.+])";
    return address.replaceAll(pattern, "[.]");
  }
}
