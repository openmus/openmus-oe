
require ../../../meta-openpli/recipes-openpli/images/openpli-enigma2-image.bb


IMAGE_INSTALL_remove = "openpli-bootlogo"

IMAGE_INSTALL += " \
	${@bb.utils.contains("MACHINE_FEATURES", "blindscan-dvbs", "enigma2-plugin-systemplugins-blindscan" , "", d)} \
	dabstreamer \
	enigma2-plugin-extensions-backupsuite \
	enigma2-plugin-extensions-devicemanager \
	enigma2-plugin-extensions-epgimport \
	enigma2-plugin-extensions-foreca \
	enigma2-plugin-extensions-youtube \
	enigma2-plugin-systemplugins-mphelp \
	glibc-gconv-iso8859-7 \
	glibc-gconv-utf-16 \
	livestreamersrv \
	rtl8192eu \
	openmus-bootlogo \
	softcam-support \

DEPENDS += " \
	${@bb.utils.contains("MACHINE_FEATURES", "blindscan-dvbs", "enigma2-plugin-systemplugins-satscan" , "", d)} \
	${@bb.utils.contains('TARGET_FPU', 'soft', '', 'nodejs', d)} \
	\
	astra-sm \
	bluez-hidd \
	ccextractor \
	dreambox-buildimage \
	dvb-apps \
	dvb-usb-drivers-meta \
	dvblast \
	dvbsnoop \
	edid-decode \
	enigma2-plugin-extensions-bitrate \
	enigma2-plugin-extensions-blackoutblind \
	enigma2-plugin-extensions-btdevicesmanager \
	enigma2-plugin-extensions-dlnaserver \
	enigma2-plugin-extensions-e2iplayer \
	enigma2-plugin-extensions-hdmitest \
	enigma2-plugin-extensions-historyzapselector \
	enigma2-plugin-extensions-lcd4linux \
	enigma2-plugin-extensions-openmultiboot \
	enigma2-plugin-extensions-oscamstatus \
	enigma2-plugin-extensions-permanentvfdclock \
	enigma2-plugin-extensions-ppanel \
	enigma2-plugin-extensions-subssupport \
	enigma2-plugin-extensions-tmbd \
	enigma2-plugin-extensions-weathermsn \
	enigma2-plugin-skins-pli-hd \
	enigma2-plugin-skins-pli-hd-fullnight \
	enigma2-plugin-skins-simple-gray-hd \
	enigma2-plugin-softcams-oscam-emu \
	enigma2-plugin-systemplugins-crossepg \
	enigma2-plugin-systemplugins-quadpip \
	enigma2-plugin-systemplugins-serviceapp \
	enigma2-plugins \
	eti-tools \
	evtest \
	exteplayer3 \
	gstplayer \
	htop \
	inadyn-mt \
	iptables \
	iw \
	libcec \
	ltrace \
	megatools \
	meta-enigma2-dvdburn \
	minisatip \
	net-tools \
	ntp \
	oe-satipclient \
	ofgwrite \
	openvpn \
	p7zip \
	pcsc-lite \
	pointercal \
	python-bluetool \
	python-cfscrape \
	python-dbus \
	python-js2py \
	python-mechanize \
	python-pycrypto \
	python-pycurl \
	python-pyexecjs \
	python-tcpbridge \
	redsea \
	rt8812au \
	rtl-sdr \
	satipclient \
	softcams-enigma2-meta \
	strace \
	tcpdump \
	tsduck \
	tsniv2ni \
	v4l-utils \
	udpxy \
	wscan \
"
