public class LeetCode_42
{
    public int trap(int[] height) {
        int res=0;
        int n= height.length;
        int lmax[]= new int[n];//
        lmax[0]=height[0];
        for(int i=1;i<n-1;i++)
        lmax[i]=Math.max(height[i],lmax[i-1]);

        int rmax[]= new int[n];//
        rmax[n-1]=height[n-1];
        for(int j=n-2;j>0;j--)
        rmax[j]=Math.max(rmax[j+1],height[j]);

        for(int i=1;i<n-1;i++)
        res+= Math.min(rmax[i],lmax[i])-height[i];
    return res;
    }
    public static void main(String[] args) {
        // Example usage
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        LeetCode_42 solution = new LeetCode_42();
        int result = solution.trap(height);

        System.out.println("Trapped rainwater: " + result);
    }
}