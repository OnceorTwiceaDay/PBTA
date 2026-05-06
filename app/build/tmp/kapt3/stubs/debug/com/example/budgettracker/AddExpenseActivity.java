package com.example.budgettracker;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0012\u0010 \u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010\'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00170\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/example/budgettracker/AddExpenseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnAddPhoto", "Landroid/widget/Button;", "btnDate", "btnEndTime", "btnSave", "btnStartTime", "db", "Lcom/example/budgettracker/AppDatabase;", "endTime", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "etAmount", "Lcom/google/android/material/textfield/TextInputEditText;", "etDesc", "imageUri", "Landroid/net/Uri;", "ivPhoto", "Landroid/widget/ImageView;", "pickImage", "Landroidx/activity/result/ActivityResultLauncher;", "", "selectedDate", "spCategory", "Landroid/widget/Spinner;", "startTime", "username", "initViews", "", "loadCategories", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupDateTimePickers", "setupPhotoPicker", "setupSaveButton", "updateDateButtonText", "updateEndTimeButtonText", "updateStartTimeButtonText", "app_debug"})
public final class AddExpenseActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.budgettracker.AppDatabase db;
    private java.util.Calendar selectedDate;
    private java.util.Calendar startTime;
    private java.util.Calendar endTime;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri imageUri;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String username;
    private com.google.android.material.textfield.TextInputEditText etAmount;
    private com.google.android.material.textfield.TextInputEditText etDesc;
    private android.widget.Button btnDate;
    private android.widget.Button btnStartTime;
    private android.widget.Button btnEndTime;
    private android.widget.Spinner spCategory;
    private android.widget.ImageView ivPhoto;
    private android.widget.Button btnAddPhoto;
    private android.widget.Button btnSave;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> pickImage = null;
    
    public AddExpenseActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void setupDateTimePickers() {
    }
    
    private final void updateDateButtonText() {
    }
    
    private final void updateStartTimeButtonText() {
    }
    
    private final void updateEndTimeButtonText() {
    }
    
    private final void loadCategories() {
    }
    
    private final void setupPhotoPicker() {
    }
    
    private final void setupSaveButton() {
    }
}