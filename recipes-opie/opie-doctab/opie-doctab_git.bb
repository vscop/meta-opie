require ${PN}.inc

inherit opie_git

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/settings/doctab;name=first \
           ${OPIE_GIT};protocol=git;subpath=apps \
           ${OPIE_GIT};protocol=git;subpath=pics"
