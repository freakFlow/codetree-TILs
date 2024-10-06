#include <iostream>
using namespace std;

int main() {
    int n, num;

    cin >> n;

    int cnt = 2;
    num = n;

    while(cnt > 0){
        cout << num << ' ';
        if(num % 5 == 0) cnt--;
        num += n;
    }

    return 0;
}