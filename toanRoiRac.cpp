#include <iostream>
using namespace std;

// Hàm kiểm tra phần tử x có trong mảng arr không
bool contains(int arr[], int n, int x) {
    for (int i = 0; i < n; i++) {
        if (arr[i] == x) return true;
    }
    return false;
}

int main() {
    int n, m;
    int A[100], B[100];

    // Nhập mảng A
    cout << "Nhap so phan tu A: ";
    cin >> n;
    cout << "Nhap mang A:\n";
    for (int i = 0; i < n; i++) {
        cin >> A[i];
    }

    // Nhập mảng B
    cout << "Nhap so phan tu B: ";
    cin >> m;
    cout << "Nhap mang B:\n";
    for (int i = 0; i < m; i++) {
        cin >> B[i];
    }

    // ===== GIAO =====
    cout << "\nGiao: ";
    for (int i = 0; i < n; i++) {
        if (contains(B, m, A[i]) && !contains(A, i, A[i])) {
            cout << A[i] << " ";
        }
    }

    // ===== HOP =====
    cout << "\nHop: ";
    // In A (không trùng)
    for (int i = 0; i < n; i++) {
        if (!contains(A, i, A[i])) {
            cout << A[i] << " ";
        }
    }
    // In thêm phần tử của B chưa có trong A
    for (int i = 0; i < m; i++) {
        if (!contains(A, n, B[i]) && !contains(B, i, B[i])) {
            cout << B[i] << " ";
        }
    }

    // ===== HIEU A - B =====
    cout << "\nHieu A - B: ";
    for (int i = 0; i < n; i++) {
        if (!contains(B, m, A[i]) && !contains(A, i, A[i])) {
            cout << A[i] << " ";
        }
    }

    // ===== HIEU B - A =====
    cout << "\nHieu B - A: ";
    for (int i = 0; i < m; i++) {
        if (!contains(A, n, B[i]) && !contains(B, i, B[i])) {
            cout << B[i] << " ";
        }
    }

    // ===== PHAN BU (hop - giao) =====
    cout << "\nPhan bu: ";
    // Lấy hợp rồi loại giao
    for (int i = 0; i < n; i++) {
        if (!contains(B, m, A[i]) && !contains(A, i, A[i])) {
            cout << A[i] << " ";
        }
    }
    for (int i = 0; i < m; i++) {
        if (!contains(A, n, B[i]) && !contains(B, i, B[i])) {
            cout << B[i] << " ";
        }
    }

    return 0;
}
