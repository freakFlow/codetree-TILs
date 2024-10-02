#include <iostream>
using namespace std;

int main() {
    int day_2, day_3, day_12;
    int n;

    day_2 = day_3 = day_12 = 0;

    for(int i=1; i<=n; i++){
        if(i % 12 == 0) day_12++;
        else if(i % 3 == 0) day_3++;
        else if(i % 2 == 0) day_2++;
    }

    cout << day_2 << ' ' << day_3 << ' ' << day_12;

    return 0;
}