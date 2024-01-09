PROJECT_ROOT="/home/ec2-user/moongi-dev-back"
JAR_FILE="$PROJECT_ROOT/moongi-dev-back-0.0.1-SNAPSHOT.jar"

APP_LOG="$PROJECT_ROOT/application.log"
ERROR_LOG="$PROJECT_ROOT/error.log"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)

# jar 파일 실행
echo "start.sh 시작" >> $DEPLOY_LOG
echo "$rds_host" >> $DEPLOY_LOG
echo "$rds_username" >> $DEPLOY_LOG

echo "$TIME_NOW > $JAR_FILE --spring.profiles.active=dev 실행" >> $DEPLOY_LOG
echo "java -jar $JAR_FILE --spring.profiles.active=dev"
nohup java -jar $JAR_FILE --spring.profiles.active=dev > $APP_LOG 2> $ERROR_LOG &

CURRENT_PID=$(pgrep -f $JAR_FILE)
echo "$TIME_NOW > 실행된 프로세스 아이디 $CURRENT_PID 입니다." >> $DEPLOY_LOG
