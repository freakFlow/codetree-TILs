#include <iostream>
using namespace std;

int main() {
    int num;
    int cnt = 0, sum = 0;

    for(int i=0; i<10; i++){
        cin >> num;
        if(num == 0) break;

        if(num % 2 == 0){
            sum += num;
            cnt++;
        }
    }

    cout << cnt << ' ' << sum;

    return 0;
}