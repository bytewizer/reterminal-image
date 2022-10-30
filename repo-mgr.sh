#!/bin/bash

# Abort script if any command returns error
set -e

_usage() {
    echo "Usage: $0 <command> [OPTIONS]"
    echo "  Commands:"
    echo "      install - Install build dependencies"
    echo "      init - Initialize build repositories"
    echo "      clean - Remove sstate cache and tmp directories"
    exit 1
}

_clone() {
    for (( i=0; i<${#repo_urls[@]}; i++ ));
    do
    
        if [ -d ${repo_dirs[$i]} ]; then
            if [ "$force" = true ] ; then
                echo "Removing ${repo_dirs[$i]}"
                rm -fr ${repo_dirs[$i]}
            else
                echo "Warning: Directory ${repo_dirs[$i]} exists. Skipping..."
                continue
            fi
        fi
        
        git clone -b ${repo_branch[$i]} ${repo_urls[$i]} ${repo_dirs[$i]}

        echo ""
    done
}

_parse_conf() {
    if [ ! -f $conf_file ]; then
        echo "$conf_file not found!"
        exit 1
    fi

    echo -e "Parsing $conf_file\n"
    repo_urls=( $(grep ^repository $conf_file | cut -d ',' -f2) )
    repo_dirs=( $(grep ^repository $conf_file | cut -d ',' -f3) )
    repo_branch=( $(grep ^repository $conf_file | cut -d ',' -f4) )
}

install() {
    echo -e "Installing dependencies\n"
    sudo apt-get update
    sudo apt-get install -y gawk wget git diffstat unzip texinfo gcc build-essential \
        chrpath socat cpio python3 python3-pip python3-pexpect xz-utils debianutils \
        iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev \
        xterm python3-subunit mesa-common-dev zstd liblz4-tool
}

clean() {
    echo -e "Removing sstate cache and tmp directories\n"
    sudo -rf ./build/sstate-cache/
    sudo -rf ./build/tmp/
}

init() {
    conf_file="default.conf"
    force=false

    while [[ $# -gt 0 ]]; do
        case $1 in
            -f|--file)
                if [ -z "$2" ]
                then
                    echo "No file specified"
                    _usage
                fi

                conf_file="$2"
                shift # past argument
                shift # past value
                ;;
            -z)
                force=true
                shift
                ;;
            *)
                echo "Unknown option: $1"
                exit 1
                ;;
        esac
    done

    _parse_conf
    _clone
}

if [[ $# -eq 0 ]] ; then
    _usage
fi

case $1 in
    init)
        shift
        init "$@"
        ;;
    clean)
        shift
        clean "$@"
        ;;
    install)
        shift
        install "$@"
        ;;
    *)
        echo "Unknown command $1"
        _usage
        ;;
esac