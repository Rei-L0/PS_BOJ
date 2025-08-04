import java.util.*;

class Solution {

    // 문자열을 문제의 규칙에 맞는 인덱스로 변환하는 함수
    public long stringToIndex(String s) {
        long index = 0;
        long powerOf26 = 1;

        // 1. 자신보다 짧은 길이의 모든 주문 개수를 더함
        for (int i = 1; i < s.length(); i++) {
            powerOf26 *= 26;
            index += powerOf26;
        }

        // 2. 같은 길이 내에서의 순서를 계산하여 더함
        long indexInGroup = 0;
        powerOf26 = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            indexInGroup += (s.charAt(i) - 'a') * powerOf26;
            if (i > 0) {
                 powerOf26 *= 26;
            }
        }
        
        // 1-based index를 위해 1을 더함
        index += indexInGroup + 1;
        return index;
    }

    // 인덱스를 규칙에 맞는 문자열로 변환하는 함수
    public String indexToString(long k) {
        // 1. 인덱스 k에 해당하는 문자열의 길이를 찾음
        int length = 1;
        long powerOf26 = 26;
        while (k > powerOf26) {
            k -= powerOf26;
            length++;
            // long의 범위를 넘어가지 않도록 주의
            if (Long.MAX_VALUE / 26 < powerOf26) {
                 powerOf26 = Long.MAX_VALUE;
            } else {
                 powerOf26 *= 26;
            }
        }

        // 2. 같은 길이 내 순서(k)를 이용해 문자열을 만듦
        k--; // 0-based index로 변환

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + (k % 26)));
            k /= 26;
        }

        return sb.reverse().toString();
    }
    
    public String solution(long n, String[] bans) {
        // bans 배열을 문제 규칙에 맞게 정렬
        Arrays.sort(bans, (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }
            return s1.compareTo(s2);
        });
        
        // 삭제된 주문을 고려하여 n값을 보정
        // 이 로직은 올바르므로 그대로 사용
        for (String ban : bans) {
            long banIndex = stringToIndex(ban);
            if (banIndex <= n) {
                n++;
            }
        }
        
        // 최종 보정된 n을 문자열로 변환
        return indexToString(n);
    }
}