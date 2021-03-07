FROM <base image that has J2EE runtime, e.g: Liberty server>

LABEL name="Bhava URL APP" \
      version="1.0" \
      vendor="Ven" \
      release="08/03/2021" \
      summary="API to convert longUrl to shortUrl." \
      description=" It can convert longUrl to shortUrl and retrieve longUrl for given shortUrl"
ENV < configure hostname, log directory, etc>
    
COPY <the artifacts like war to target dir in the docker image /usr/wlp/opt....>

RUN < shell commands for install software, utilities, file permissions, run setup scripts,..> 

EXPOSE < service ports here like 9443 9080 >
CMD [] <provide any commanda to run like CMD ["node", "src/index.js"]>