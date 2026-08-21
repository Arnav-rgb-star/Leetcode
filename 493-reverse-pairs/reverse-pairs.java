class Solution {
    int cnt;

    void ms(int a[],int l,int r){
        
        if(l>=r) return ;
        int m = l+(r-l)/2; 
        
        ms(a,l,m);
        ms(a,m+1,r);

        int j = m+1;
        for(int i=l;i<=m;i++){
            while(j<=r && a[i] > 2L*a[j]) ++j;
            cnt+=(j-(m+1));
        }
        merge(a,l,m,r);
    }

    void merge(int a[],int l,int mid,int r){
        int n = mid+1-l;
        int m = r-mid;

        int x[] = new int[n];
        int y[] = new int[m];


        for(int i=0;i<n;i++) x[i]=a[l+i];
        for(int j=0;j<m;j++) y[j] = a[mid+1+j];

        int i=0;
        int j=0;
        int k=l;

        while(i<n && j<m){
            if(x[i]<=y[j]){
                a[k++] = x[i];
                ++i; 
            }else{
                a[k++] = y[j];
                ++j;
            }
        }
        while(i<n) a[k++]=x[i++];
        while(j<m) a[k++]=y[j++];
        return ;

    }
    public int reversePairs(int[] nums) {
        
        ms(nums,0,nums.length-1);
        return cnt;
    }
}