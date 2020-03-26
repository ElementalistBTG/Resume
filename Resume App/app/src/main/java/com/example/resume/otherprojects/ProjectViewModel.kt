package com.example.resume.otherprojects

import androidx.lifecycle.ViewModel

class ProjectViewModel : ViewModel() {

    fun initDataset() : ArrayList<Project> {
        val projects = ArrayList<Project>()
        projects.add(
            Project("• Elastic Stack Implementation Project","Created an AWS machine and implemented the Elastic Stack on it. The data were provided from AWS Cloudwatch (created from a MongoDB), forwarder with an AWS Lambda function, filtered at my Logstash service, indexed at Elasticseach and visualised at Kibana. The project was implemented for a startup who wanted to have insight on their log files.")
        )
        projects.add(
            Project("• Display of Orientation of Android Smartphone using LabView","Using the LabView software and an Android application which sends data over UDP packets i created a visualisation of the orientation sensor. The user could also save/load his previous sessions.")
        )
        projects.add(
            Project("• Wifi and 4G analysis in a virtual shopping mall using ns3 software","1) Using the ns3 software i have created a shopping mall and placed eNBs (both femtocells and macrocells) inside and outside of the mall to monitor the performance of the system. The traffic was aggregated at the MME/S-GW and forwarded though an ISP node to the internet.\n" +
                    "2) Later i have added wifi Access Points and extra UEs to monitor the traffic towards the same ISP and remote host (the internet side).\n" +
                    "3) I have also tried to implement an LAA solution to measure the interference between the wifi and 4g cells but it was infeasible at the time (ns3 had very limited solutions available)")
        )
        projects.add(
            Project("• Battlefield - Web Application","Using HTML5, CSS3, Javascript, PHP and MySQL i have created an online, multiplayer version of the famous game Battefield table game.")
        )

        return projects
    }

}