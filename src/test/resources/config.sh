#!/bin/bash

cluster=$1

set -x

src='/Users/apple/Documents/school/server/netease/src/test/resources'
cd $src
ls
for file in `ls ${src}/freemarker/*.properties` ; do
    sed -ie "s/{cluster}/$cluster/g" $file
done


