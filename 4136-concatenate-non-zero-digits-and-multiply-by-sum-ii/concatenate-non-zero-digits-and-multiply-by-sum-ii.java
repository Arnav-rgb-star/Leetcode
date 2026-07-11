class Solution{
    public int[] sumAndMultiply(String s,int[][] queries){
        long mod=(long)1e9+7;
        int n=s.length();
        int ans[]=new int[queries.length];

        long count[]=new long[n];
        if(s.charAt(0)!='0')++count[0];

        for(int i=1;i<n;i++){
            count[i]=count[i-1];
            if(s.charAt(i)!='0')++count[i];
        }

        long prefix[]=new long[n];
        prefix[0]=s.charAt(0)-'0';

        for(int i=1;i<n;i++){
            prefix[i]=(prefix[i-1]+s.charAt(i)-'0')%mod;
        }

        long val[]=new long[n];
        val[0]=s.charAt(0)-'0';

        for(int i=1;i<n;i++){
            val[i]=val[i-1];
            if(s.charAt(i)!='0'){
                val[i]=(val[i]*10+s.charAt(i)-'0')%mod;
            }
        }

        long power[]=new long[n+1];
        power[0]=1;

        for(int i=1;i<=n;i++){
            power[i]=power[i-1]*10%mod;
        }

        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];

            long lastSum= l>0 ? prefix[l-1] : 0;

            long sum=(prefix[r]-lastSum + mod)%mod;

            long previousCount=l>0?count[l-1]:0;
            int digits=(int)(count[r]-previousCount);

            long lastValue=l>0? val[l-1]*power[digits]%mod:0;
            long x=(val[r]-lastValue+mod)%mod;

            ans[i]=(int)(x*sum%mod);
        }

        return ans;
    }
}