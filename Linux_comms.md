1. Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животные (заполнив файл лошадьми, верблюдами и
ослами), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).


sudo -s
cat > 'Domashnie zhivotnie'
Собаки
Кошки
Хомяки
cat 'Domashnie zhivotnie'
cat > 'Viuchnie zhovotnie'
Лошади
Верблюды
Ослы
cat 'Viuchnie zhovotnie'
ll
cat 'Domashnie zhivotnie' 'Viuchnie zhovotnie' > 'Domashnie zhivotnie'
cat 'Domashnie zhivotnie'
rm 'Viuchnie zhovotnie'
mv 'Domashnie zhivotnie' 'Druzia cheloveka'
ll


2. Создать директорию, переместить файл туда.


mkdir 'Pitomnik'
ll
mv 'Druzia cheloveka' 'Pitomnik'


3. Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.


apt update
cd Downloads
ll
dpkg -i mysql-apt-config*
apt-get update
apt install mysql-server

4. Установить и удалить deb-пакет с помощью dpkg.


cd Downloads
dpkg -i google-chrome-stable_current_amd64.deb
apt show google-chrome-stable

apt list --installed |grep chrome
dpkg -r google-chrome-stable