#include <iostream>
#include <climits>
using namespace std;

int main() {
    int N;
    int max1 = INT_MIN, max2 = INT_MIN;
    int num;

    cin >> N;

    for(int i=0; i<N; i++){
        cin >> num;
        if(num > max1){
            max2 = max1;
            max1 = num;
        }else if(num > max2){
            max2 = num;
        }
    }

    cout << max1 << ' ' << max2;
    
    return 0;
}