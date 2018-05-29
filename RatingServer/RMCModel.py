import pickle
import pandas as pd
import numpy as np
from sklearn import linear_model as lm
from sklearn.svm import SVC
from sklearn.tree import DecisionTreeClassifier as dtc
from sklearn.neighbors import KNeighborsClassifier as knnc
from sklearn.naive_bayes import GaussianNB as gnb
from sklearn.model_selection import cross_val_score
from sklearn.model_selection import train_test_split 
from sklearn.metrics import accuracy_score, confusion_matrix


df = pd.read_csv('promise.csv')
# data.head()
df = df.replace('?',np.nan)
df = df.dropna()

df = df.replace('true','1')
df = df.replace('false','0')

train, test = train_test_split(df, test_size=0.2)

features = ['loc','cc','n','volume',
			'proglength','difficulty','effort',
			'bug','time_est','lOCode','lOComment',
			'lOBlank','lOCodeAndComment','uniq_Op',
			'uniq_Opnd','total_Op','total_Opnd']

target = ['defects']

# print(df)


# print(df.shape)
# print(train[features].shape)
# print(train[target].shape)
# print(train[target].values.ravel().shape)
# # print(test.shape)

# Y = train[target].values.reshape(train[target].shape[0])
# print(Y)

classifiers = [
    knnc(),
    dtc(),
    SVC(),
    SVC(kernel='linear'),
    gnb()
]

classifier_names = [
    'K nearest neighbors',
    'Decision Tree Classifier',
    'SVM classifier with RBF kernel',
    'SVM classifier with linear kernel',
    'Gaussian Naive Bayes'
]

# for clf, clf_name in zip(classifiers, classifier_names):
#     cv_scores = cross_val_score(clf, train[features], train[target], cv=5)
    
#     print(clf_name, ' mean accuracy: ', round(cv_scores.mean()*100, 3), \
#     	'% std: ', round(cv_scores.var()*100, 3),'%')





# final_model_smv_lin = SVC(kernel='linear').fit(train[features], Y)
final_model_gnb = gnb().fit(train[features], train[target])

model_file = "model_GNB.pkl"
with open(model_file, 'wb') as file:
    pickle.dump(final_model_gnb, file)

# y_hat_svm = final_model_smv_lin.predict(test[features])
y_hat_gnb = final_model_gnb.predict(test[features])
# for x in y_hat_gnb:
#     print(x)
b = [
        [190,3,600,4348.76,0.06,17.06,74202.67,1.45,4122.37,129,29,28,2,17,135,329,271]
    ]


print(final_model_gnb.predict(b))
# print('test accuracy for SVM classifier with a linear kernel:'\
#       , round(accuracy_score(test[target], y_hat_svm)*100, 2), '%')


print('test accuracy for Gaussian naive bayes classifier:', \
      round(accuracy_score(test[target], y_hat_gnb)*100, 2),'%')

