package InterviewProblems.AmazonInterviewProblems.AmazonOA;

/*
Third-party companies that sell their products on Amazon.com are able to analyze the customer reviews for their products in real time. Imagine that Amazon is creating a category called "five-star sellers" that will only display products sold by companies whose average percentage of five-star reviews per-product is at or above a certain threshold. Given the number of five-star and total reviews for each product a company sells, as well as the threshold percentage, what is the minimum number of additional fivestar reviews the company needs to become a five-star seller?

For example, let's say there are 3 products (n = 3) where productRatings = [[4,4], [1,2], [3, 6]], and the percentage ratings Threshold = 77. The first number for each product in productRatings denotes the number of fivestar reviews, and the second denotes the number of total reviews. Here is how we can get the seller to reach the threshold with the minimum number of additional five-star reviews:

Before we add more five-star reviews, the percentage for this seller is ((4 / 4) + (1/2) + (3/6))/3 = 66.66%
If we add a five-star review to the second product, the percentage rises to ((4 / 4) + (2/3) +(3/6))/3 = 72.22%
If we add another five-star review to the second product, the percentage rises to ((4 / 4) + (3/4) + (3/6))/3 = 75.00%
If we add a five-star review to the third product, the percentage rises to ((4/4) + (3/4) + (4/7))/3 = 77.38%
At this point, the threshold of 77% has been met. Therefore, the answer is 3 because that is the minimum number of additional five-star reviews the company needs to become a five-star seller.

Function Description

Complete the function fiveStarReviews in the editor below.

fiveStarReviews has the following parameters:

int productRatings[n][2]: a 2-dimensional array of integers where the ith element contains two values, the first one denoting fivestar[i] and the second denoting total[i]

int ratingsThreshold: the threshold percentage, which is the average percentage of five-star reviews the products need for the company to be considered a five-star seller

Returns:

int: the minimum number of additional five-star reviews the company needs to meet the threshold ratingsThreshold

Constraints

1<=n<=200
0 <= fivestar<total<=100
1<=ratingsThreshold<100
The array productRatings contains only non-negative integers.


 */
public class Amazon_OA_FiveStarSellers {

    public static void main(String[] args) {

        int [][] nums = {{4,4},{1,2},{3,6}};
        System.out.println(fiveStarSellers(nums,77));

    }
    public static int fiveStarSellers(int [][] data, double target){

        int res =0 ;

        target = target * data.length * 1.0 / 100;
        double curr = 0;

        while(curr < target){

            curr = 0;
            double temp =0;
            int index = -1;
            for(int i=0;i<data.length;i++){

                double d = (data[i][0]+1)*1.0 / (data[i][1]+1) - data[i][0]*1.0/data[i][1];

                if(d>temp){
                    temp = d;
                    index = i;
                }
                curr += data[i][0]*1.0/data[i][1];
            }
            curr = curr - data[index][0]*1.0/data[index][1];
            data[index][0]+=1;
            data[index][1]+=1;
            curr+= data[index][0]*1.0/data[index][1];
            res++;
        }
      return res;
    }
}
