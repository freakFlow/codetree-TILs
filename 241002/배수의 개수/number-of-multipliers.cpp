#include <iostream>
using namespace std;

int main() {
    int num;
    int count_3, count_5;

    count_3 = count_5 = 0;

    for(int i=0; i<10; i++){
        cin >> num;

        if(num % 3 == 0) count_3++;
        
        if(num % 5 == 0) count_5++;
    }

    cout << count_3 << ' ' << count_5;

    return 0;
}