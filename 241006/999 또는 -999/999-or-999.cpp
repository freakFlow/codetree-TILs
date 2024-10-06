#include <iostream>
#include <climits>
using namespace std;

int main() {
    int num;
    int min = INT_MAX, max = INT_MIN;

    for(int i=0; i<100; i++){
        cin >> num;
        if(num == 999 || num == -999) break;
        if(num < min) min = num;
        if(num > max) max = num;
    }

    cout << max << ' ' << min;

    return 0;
}