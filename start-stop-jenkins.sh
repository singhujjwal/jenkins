aws ec2 stop-instances --instance-ids i-010b4934d0ea7a35f
aws ec2 start-instances --instance-ids i-010b4934d0ea7a35f
aws ec2 describe-instances \
    --instance-ids i-010b4934d0ea7a35f  | jq -r '.Reservations[0].Instances[0].PublicIpAddress'
aws ec2 describe-instances \
    --instance-ids i-010b4934d0ea7a35f  | jq -r '.Reservations[0].Instances[0].PublicIpAddress