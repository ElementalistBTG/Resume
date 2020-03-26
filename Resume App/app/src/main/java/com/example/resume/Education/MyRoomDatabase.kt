package com.example.resume.Education

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.resume.Education.Certifications.Certification
import com.example.resume.Education.Certifications.CertificationDao
import com.example.resume.Education.Degrees.Degree
import com.example.resume.Education.Degrees.DegreeDao
import com.example.resume.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Annotates class to be a Room Database with a table (entity) of the Degree class
@Database(entities = arrayOf(Degree::class,Certification::class),version = 1,exportSchema = false)
public abstract class MyRoomDatabase : RoomDatabase() {

    abstract fun degreeDao(): DegreeDao
    abstract fun certificationDao(): CertificationDao

    private class MyDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            INSTANCE?.let { database ->
                scope.launch {
                    val degreeDao = database.degreeDao()

                    //delete all content here
                    degreeDao.deleteAllDegrees()

                    //add data once (because we do it onCreate)
                    degreeDao.insert(
                        Degree(
                            "res:///" + R.drawable.cv,
                            "MSc in Computer, Telecommunications and Network Engineering",
                            "Specialization in Networking",
                            "Oct 2018 - Apr 2020",
                            "In this master i had courses focused on networking, big data and web applications. In my thesis i created a novel Indoor Positioning System for Android devices that used Augmented Reality and wireless sensors for position estimation."
                        )
                    )
                    degreeDao.insert(
                        Degree(
                            "res:///" + R.drawable.cv,
                            "MSc in Information Systems",
                            "Specialization in Security",
                            "Oct 2013 - July 2015",
                            "In this master i had courses on Security, Big Data, Networking, Systems Architecture and web applications. In my thesis i proposed a novel algorithm for assessing reachability queries in graphs."
                        )
                    )
                    degreeDao.insert(
                        Degree(
                            "res:///" + R.drawable.cv,
                            "Bachelor",
                            "Specialization: Telecommunication Engineer",
                            "Sept 2008 - July 2012",
                            "In my bachelor most of the courses were focused on telecommunications. Except from those, we were also taught C and C++ along with some courses on basic networking, systems architectures and security."
                        )
                    )

                    val certificationDao = database.certificationDao()
                    certificationDao.deleteAllcerts()
                    certificationDao.insert(
                        Certification(
                            "Deep learning specialization courese",
                            "Coursera",
                            "Oct 2019",
                            "I have completed the first 3 courses of the Coursera Deep learning specialization that consisted of the courses: 'Neural Networks and Deep Learning', 'Structuring Machine Learning Projects' and 'Improving Deep Neural Networks: Hyperparameter tuning, Regularization and Optimization'."
                        )
                    )
                    certificationDao.insert(
                        Certification(
                            "Introduction to Augmented Reality and ARCore",
                            "Coursera",
                            "Aug 2019",
                            "Basic course about the ARCore library."
                        )
                    )
                    certificationDao.insert(
                        Certification(
                            "Android Developement (Java)",
                            "Coursera",
                            "Nov 2015 - Dec 2015",
                            "Basic course that introduced me to the Android platform. There i learned the basics concepts of Android development."
                        )
                    )
                    certificationDao.insert(
                        Certification(
                            "Ground crew Instructor certification",
                            "Hellenic Air Force",
                            "Oct 2015",
                            "In this seminar of 5 weeks, we were taught the proper way to teach other people with techniques such as Instructor-led classroom training and Hands-on training."
                        )
                    )
                    certificationDao.insert(
                        Certification(
                            "Flight safety and aircraft incidents analysis",
                            "Hellenic Air Force",
                            "Mar 2014",
                            "This seminar lasted 8 weeks and we learned how to properly investigate aircraft incidents. This experience was unique in every way because we learned how to approach an incident with such ways that lead you to uncover the errors that occurred that led to the incident"
                        )
                    )
                }
            }
        }
    }


    companion object{
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MyRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): MyRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this)  {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyRoomDatabase::class.java,
                    "my_database"
                )
                    .addCallback(MyDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                //return instance
                instance
            }
        }
    }

}