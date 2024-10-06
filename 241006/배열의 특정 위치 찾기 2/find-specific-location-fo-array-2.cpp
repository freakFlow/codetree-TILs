#include <iostream>
using namespace std;

int main() {
    int sum1 = 0, sum2 = 0;
    int num;

    for(int i=0; i<10; i++){
        cin >> num;
        if(i % 2 == 0) sum1 += num;
        else sum2 += num;
    }

    cout << (sum1 > sum2 ? sum1 - sum2 : sum2 - sum1);

    return 0;
}