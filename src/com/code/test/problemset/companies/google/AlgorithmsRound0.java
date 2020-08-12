package com.code.test.problemset.companies.google;

public class AlgorithmsRound0 {

    public static void main(String[] args) {

    }

    public static void solve() {

    }
    /*

You are given uniform random number function().

random(n)  - 0 to n-1 with equal probability.
backlisted array -


n = 10
blacklisted { 1, 3, 4, 9}

{0, 2, 5, 6, 7, 8} - ⅙ probability (uniform distribution)


// M blacklisted Number
// N number
// P(n) =  (N’ - M) / N

// 1 2 3 4
1 / 4 - (1 / 4 + 1 / 4 + 1 / 4)
1 / N  - M / N

p[k] = p[ k * [1 - M] / N]

public class RandomWhiteListe{
    static int[] whiteList;
    public RandomWhiteListe(int[] blackListed, int n){
        whiteList = new int[n - blackListed.size()];
        int h = 0;
        for(int i = 0; i < n; i++){
            if(!Arrays.find(blackListed, i)){
                whiteList[h++] = i;
        }
    }
}

public int rand(int n){
int rI = random(n) % whiteList.size();
return whiteList[rI];
}


public int rand2(int n, Set<Integer> blackListed){
	// Set<Integer> blackListSet = new HashSet(blacklistedArr);
    int r = random(n);
    while(blackListed.contains(r)){
        r = random(n);
    }
    return r;
    }
}


2.


dp[0] = 1                         1
dp[1] = 2                         1 + 1
dp[2] = dp[1] + 2,  ==> 4         1 + (1+2)
dp[3] = dp[3] + 3 ==> 7           1 + (1+2+3)
dp[4] = dp[3] + 4 ==> 11          1 + (1+2+3+4)
dp[5] = dp[4] + 5 ==> 16          1 + (1+2+3+4+5)
dp[6] = dp[5] + 6 ==> 22          1 + (1+2+3+4+5+6) == 1 + (n(n+1) / 2)

// https://www.youtube.com/watch?v=5Vpfef_6HqI
// https://www.youtube.com/watch?v=8rdV6P5bkBs

     */
}
