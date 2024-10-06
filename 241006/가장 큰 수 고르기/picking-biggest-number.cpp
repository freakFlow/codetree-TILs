#include <iostream>
#include <climits>
using namespace std;

int main() {
    int max = INT_MIN;
    int num;

    for(int i=0; i<10; i++){
        cin >> num;
        if(num > max) max = num;
    }

    cout << max;

    return 0;
}