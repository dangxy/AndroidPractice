package com.dangxy.androidpractice.realm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dangxy.androidpractice.R;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        for (int i = 1; i < 50; i++) {
            Dog dog = realm.createObject(Dog.class);
            dog.setAge("" + i);
            dog.setName("xiaoBen" + i);
            realm.copyFromRealm(dog);
        }
        realm.commitTransaction();

        final RealmResults<Dog> dogList = realm.where(Dog.class).findAll();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Dog dog = dogList.get(5);
                dog.deleteFromRealm();

                dogList.deleteFirstFromRealm();
            }
        });
        Dog dog = realm.where(Dog.class).equalTo("age", "2").findFirst();
        realm.beginTransaction();
        dog.setName("xx00");
        realm.commitTransaction();


    }
}
