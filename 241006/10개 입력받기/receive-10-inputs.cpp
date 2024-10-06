#include <iostream>
using namespace std;

int main() {
    int num;
    int sum = 0, cnt = 0;

    for(int i=0; i<10; i++){
        cin >> num;
        if(num == 0) break;
        sum += num;
        cnt++;
    }

    cout << fixed;
    cout.precision(1);

    cout << sum << ' ' << (double)sum / cnt;

    return 0;
}