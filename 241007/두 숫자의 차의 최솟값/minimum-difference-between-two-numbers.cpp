#include <iostream>
#include <climits>
using namespace std;

int main() {
    int n;
    int temp;
    int min = INT_MAX;

    cin >> n;
    cin >> temp;

    for(int i=1; i<n; i++){
        int num;
        cin >> num;
        if(num - temp < min) min = num - temp;
        temp = num;
    }

    cout << min;

    return 0;
}