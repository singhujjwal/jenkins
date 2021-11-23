
kubectl create secret docker-registry regcred \
    --docker-server=https://index.docker.io/v1/ \
    --docker-username=$REGISTRY_USER \
    --docker-password=$REGISTRY_PASS \
    --docker-email=$REGISTRY_EMAIL


ssh-keygen -m PEM -t rsa -P ""
ssh-keyscan -t rsa github.com >> ~/.ssh/known_hosts_github


cat > ~/.gitconfig <<EOF
Host github.com
  HostName github.com
  StrictHostKeyChecking no
EOF 


kubectl create secret generic github-token --from-literal=github-token-name='ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'

export TOKEN='xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'

kubectl create secret generic ssh-key-secret \
    --from-file=ssh-privatekey=.ssh/id_rsa \
    --from-file=ssh-publickey=.ssh/id_rsa.pub \
    --from-file=config=~/.gitconfig



kubectl exec -i -t kaniko -- /bin/sh -c 'env | grep TOKEN'


git clone  https://singhujjwal:$TOKEN@github.com/singhujjwal/kaniko-demo.git
