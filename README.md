# <p align="center">
 ![image](https://user-images.githubusercontent.com/76757642/236618771-1f2d7035-eb44-476e-9d64-503e4208855b.png)
</p>

# Plant Disease Detection Android App





This is an Android app for detecting plant diseases using MobileNet V2 model and Our proposed model. The app is built using Kotlin programming language and follows MVVM design pattern with Repository pattern using Coroutines and Room Database. The app also integrates Firebase for backend, including 3 types of authentication and Firebase Cloud Messaging (FCM) for push notifications. Additionally, the app supports voice search in both Arabic and English languages.

## Features

- Detects plant diseases using MobileNet V2 model and Our proposed model
- Provides tips for users based on the classification of the input image
- Supports voice search in Arabic and English languages
- Includes 3 types of authentication through Firebase (email/password, Google, and phone)
- Uses Firebase Cloud Messaging (FCM) for push notifications
- Follows MVVM design pattern with Repository pattern using Coroutines and Room Database
- Videos for diseases & tips (English & Arabic)
- Language Support
- Posts added by the admin
- Sharing posts & classification results via other apps
- Ofline classification

## Usage

Upon launching the app, users can either choose to capture an image of the plant or select an existing image from their device's gallery. Once an image is selected, the app uses MobileNet V2 model to detect if the input image is a plant or not. If it is a plant, the app then uses our proposed model to classify the plant disease and provides tips for users based on the classification. The app also supports voice search, allowing users to search for plant diseases using voice commands in both Arabic and English languages.

## Technologies Used

- Kotlin programming language
- python
- TF light
- Firebase for backend and authentication
- Firebase Cloud Messaging (FCM) for push notifications
- MVVM design pattern
- Repository pattern 
- Coroutines
- Room Database

## Architecture

![image](https://user-images.githubusercontent.com/76757642/236618392-272d8666-66fa-4e4b-8e8c-817b60aa331d.png)

## Credits

### This app was developed by: 
- [Hady Atef](https://github.com/hady-o)
- [Hady Ahmed](https://github.com/HadyAhmed00)
- [Hady Ehab](https://github.com/HodBossHod)
- [Haithem Mahmoud](https://github.com/haitham2001)
- [Hany mohamed](https://github.com/HaniASU)
### as a Graduation project. 

### Our proposed model used in this app was trained on the Kaggle, Dell and other dataset.

## Contact

If you have any questions or suggestions regarding the app, please contact hadyatef70@gmail.com.
