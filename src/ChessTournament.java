import java.util.*;

public class ChessTournament {

	public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            System.out.println("enter value of n and k");
            
            int n=sc.nextInt();
            int k=sc.nextInt();
           
            int[][] matrix = new int[n][n];
            int[] check = new int[n*n];
            int c=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(j>i){
                        matrix[i][j]=1;
                    }
                    else{
                        matrix[i][j]=0;
                    }
                }
                  
            }
            check[c++] = cost(matrix,n);
            int i,j,flag=0;
            for(i=0;flag!=1 && i<n;i++){
                for(j=1;j<n;j++){
                    if(i<j){
                        if(cost(matrix,n)==k){
                            flag=1;
                            break;
                        }
                    
                        else{
                                matrix[j][i]=1;
                                matrix[i][j]=0;
                                if(contains(check,c,cost(matrix,n))) {
                                    matrix[j][i]=0;
                                    matrix[i][j]=1;
                                }
                                else {
                                    check[c++] = cost(matrix,n);
                                }
                        }
                    }  
                    for(int p=0;p<n;p++){
                    for(int q=0;q<n;q++){
                        System.out.print(matrix[p][q]+" ");
                    }
                    System.out.println("");     
                    }  
                    System.out.println("");
                            
                }   
            
            }
            
            
            
            
            
            if(flag==1){
                for(i=0;i<n;i++){
                    for(j=0;j<n;j++){
                        System.out.print(matrix[i][j]+" ");
                    }
                    System.out.println("");
                }
            }
            else{
                System.out.println("-1");
            }
            
            
            
            
          
	}
        
        public static boolean contains(int check[],int c,int cost){
            for(int i=0;i<c;i++){
                if(check[i]== cost){
                    return true;
                }
            }
            return false;
        };
        
        public static int cost(int matrix[][],int n){
            
            int temp,total = 0;
            
            for(int i=0;i<n;i++){
                temp = 0;
                for(int j=0;j<n;j++){
                    temp = temp + matrix[i][j];
                }
                total = total + (temp*temp);
            }
            
            return total;
        }
        
    }
