#include <iostream>
using namespace std;

int main() {
    int n;
    double num, sum = 0;

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> num;
        sum += num;
    }

    sum /= n;
    
    cout << fixed;
    cout.precision(1);

    cout << sum << endl;
    if(sum >= 4) cout << "Perfect";
    else if(sum >= 3) cout << "Good";
    else cout << "Poor";

    return 0;
}