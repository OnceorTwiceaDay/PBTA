# Personal Budget Tracker

video Presentation link :
https://youtu.be/l4prsRCa624
This is our Personal Budget tracker 

A comprehensive, private, and user-friendly Android application designed to help users manage their finances by tracking income, expenses, and monthly spending goals.

## 🚀 Features

### 🔐 Security & Privacy
*   **User Authentication:** Secure Login and Registration system.
*   **Robust Passwords:** Passwords must contain an uppercase letter, lowercase letter, number, and special character.
*   **Data Isolation:** Each user's data is strictly private. You only see your own transactions and goals.
*   **Account Management:** Options to Logout, Switch User, or permanently Delete Account.

### 💰 Financial Tracking
*   **Income Tracking:** Record your earnings with descriptions, dates, and times.
*   **Expense Management:** Track spending with:
    *   Date and specific Start/End times.
    *   Custom categories.
    *   **Photo Attachments:** Optionally attach a photograph (e.g., a receipt) to any expense.
*   **Live Balance:** A dynamic dashboard showing your current total balance (Income - Expenses).

### 🎯 Goals & Reports
*   **Monthly Goals:** Set minimum and maximum spending targets for any month.
*   **Detailed Reports:** View filtered transactions for user-selectable date ranges.
*   **Category Analytics:** See exactly how much you spent on each category during a specific period.
*   **Goal Comparison:** Instantly see how your actual spending compares to your set goals in your reports.

### 🎨 User Interface
*   **Material 3 Design:** A modern, clean, and responsive UI.
*   **Transaction Indicators:** Recent transactions are color-coded (Green for Income, Red for Expenses) with +/- signs for quick recognition.
*   **Interactive List:** Swipe left or right on the dashboard to quickly delete any transaction.

## 🛠 Tech Stack
*   **Language:** Kotlin
*   **Database:** Room (SQLite) for robust offline storage.
*   **UI Components:** Material Design 3, ConstraintLayout, RecyclerView, CardView.
*   **Architecture:** MVVM-ready with Lifecycle and Coroutines for smooth performance.

## 📦 Installation
1.  Clone the repository.
2.  Open the project in **Android Studio**.
3.  Ensure you have the latest Android SDK and Gradle version.
4.  Build and Run the `:app` module on an emulator or physical device.

## 📂 Project Structure
*   `Expense.kt` / `Income.kt` / `Goal.kt` / `User.kt`: Data entities.
*   `AppDao.kt`: Database access objects and queries.
*   `MainActivity.kt`: The main dashboard and balance overview.
*   `AddExpenseActivity.kt` / `AddIncomeActivity.kt`: Transaction entry screens.
*   `ReportActivity.kt`: Date-range filtering and financial summaries.
*   `RegisterActivity.kt` / `LoginActivity.kt`: User security management.

---

