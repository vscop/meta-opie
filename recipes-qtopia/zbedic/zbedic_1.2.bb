DESCRIPTION = "A dictionary application for Qt/E based Palmtop Environments"
HOMEPAGE = "http://bedic.sourceforge.net/"
AUTHOR = "Rafal Mantiuk <rafm@users.sourceforge.net>"
SECTION = "opie/applications"
LICENSE = "GPLv2+"
DEPENDS = "libbedic"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}/misc"
PR = "r4"

SRC_URI = "${SOURCEFORGE_MIRROR}/bedic/zbedic_${PV}-2.tgz;subdir=${BPN}-${PV} \
           file://opie-icons.patch \
           file://qtopia17.patch \
           file://stdlib_h.patch"

LIC_FILES_CHKSUM = "file://COPYING;md5=c00465d31e9747ffe39d09a26ad57b6b \
                    file://src/zbedic.cpp;beginline=10;endline=22;md5=3a9fd497ac9af3b08b0e76a308b68107"

inherit opie
export OE_QMAKE_LINK="${CXX}"
export OE_QMAKE_CXXFLAGS=" -DVERSION=\\"${PV}.2\\" -DPREFIX_PATH=\\"/usr\\""

EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${STAGING_INCDIR}/libbedic LIBS+=-lbedic LIBS+=-lsqlite3 TARGET=zbedic"

do_configure_prepend() {
	rm -f Makefile
	qmake -project
}

do_install() {
	install -d ${D}${palmtopdir}/pics/zbedic/
	install -d ${D}${palmtopdir}/help/html/
	# we copy small icons - in other way QVGA users will complain
	install -m 0644 ${S}/misc/small_icons/*.png ${D}${palmtopdir}/pics/zbedic/
	install -m 0644 ${S}/misc/large_icons/zbedic.png ${D}${palmtopdir}/pics/
	install -m 0644 ${S}/doc/manual/*.html ${D}${palmtopdir}/help/html/
	rm ${D}${palmtopdir}/pics/zbedic/zbedic.png

	# those ones are taken from OPIE so they have proper size (depend on device)
	rm ${D}${palmtopdir}/pics/zbedic/back.png
	rm ${D}${palmtopdir}/pics/zbedic/forward.png
}

PACKAGES = "${PN}-dbg ${PN}-doc ${PN} ${PN}-dev"

FILES_${PN}-doc += "${palmtopdir}/help"

SRC_URI[md5sum] = "c7e8e267567a96cff7920a0365978c4d"
SRC_URI[sha256sum] = "b991cc5635849353081c2a3350142484763323bc58bfa49b62285645aac129b9"
